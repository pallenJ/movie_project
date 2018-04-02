package mp.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mp.board.bean.Notice;
import mp.board.model.NoticeDao;
import mp.member.model.MemberDao;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;

	@Autowired
	MemberDao memDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	@Override
	public List<Notice> noticePaging(int page, int cnum) {
		/*
		 * int pageFirst = 10*(page/10)+1; int pageLast = 10*(page/10+1);
		 */
		List<Notice> list = noticeDao.noticelist();

		// Collections.reverse(list);

		int maximum = list.size();
		int start = 10 * (page - 1);
		int end = Math.min(10 * page, maximum);

		return list.subList(start, end);
	}

	@Override
	public List<Notice> noticePaging(int cnum) {
		// TODO Auto-generated method stub
		return noticePaging(1, cnum);
	}
	
	@Override
	public List<Notice> noticePaging(int page,int cnum,String search,String keyword) {
		/*int pageFirst = 10*(page/10)+1;
		int pageLast = 10*(page/10+1);*/
		List<Notice> list = noticeDao.noticeSearch(search, keyword); 
//		Collections.reverse(list);
		
		int maximum = list.size();
		int start = 10*(page-1);
		int end   = Math.min(10*page, maximum);
		
		return list.subList(start, end);
	}

	@Override
	public int[] noticePaging(int cnum, int pnum, int page) {
		// TODO Auto-generated method stub

		int allCount = noticeDao.noticelist().size();
		int last = allCount / cnum + (allCount % cnum == 0 ? 0 : 1);
		if (page > last)
			page = last;
		int pagingNum = pnum * ((page - 1) / pnum);
		int pageLast = last - pagingNum >= pnum ? pnum : last % pnum;
		return new int[] { pagingNum, pageLast, last, page };
	}
	
	@Override
	public int[] noticePaging(int cnum, int pnum, int page,String search,String keyword) {
		// TODO Auto-generated method stub
		
		int allCount = noticeDao.noticeSearch(search, keyword).size();
		int last = allCount/cnum+(allCount%cnum==0?0:1);
		if(page>last) page = last;
		int pagingNum=pnum*((page-1)/pnum);
		int pageLast = last-pagingNum>=pnum?pnum:last%pnum;
		return new int[]{pagingNum,pageLast,last,page};
	}

	
	@Override
	public String noticeWrite(String id, String head, String title, String content,String uploadPath,MultipartFile upload) throws Exception{
		String writer = memDao.myinfo(id).getNo();
		String savename = null;
		String name = upload.getOriginalFilename();
		if(name != null && !name.equals("")) {
			
		if(
				!name.endsWith(".jpg")&&
				!name.endsWith(".png")&&
				!name.endsWith(".gif")
				) {
			log.debug("업로드가 불가능한 파일입니다");
			return "업로드가 불가능한 파일입니다";
		}
		
		savename = UUID.randomUUID().toString();
		
		fileUpload(savename, uploadPath, upload);
		}
		
		Notice notice = new Notice();
		
		notice.setHead(head);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setUpload(savename);
		notice.setUploadPath(uploadPath);
		notice.setWriter(writer);

		noticeDao.register(notice);
		return "";
	}
	
/*	@Override
	public void noticeWrite(String id, String head, String title, String content){
		String writer = memDao.myinfo(id).getNo();
		
		
		Notice notice = new Notice();
		
		notice.setHead(head);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setUpload("");
		notice.setUploadPath("");
		notice.setWriter(writer);
		
		noticeDao.register(notice);
	}*/

	@Override
	public void noticeEdit(String no, String head, String title, String content,String fileDelete,String path,MultipartFile newfile) throws Exception {
		Notice notice = noticeDao.noticedetail(Integer.parseInt(no));
		
		boolean fileEdit = (fileDelete==null&&newfile!=null)||fileDelete!=null;
		log.debug("new file={}",newfile);
		log.debug("fileDelete={}",fileDelete);
		if(fileEdit) {
			String name = newfile.getOriginalFilename();
			if(notice.getUpload()!=null&&!notice.getUpload().equals("")) {
				boolean test=fileDelete(notice.getUploadPath(), notice.getUpload());
				log.debug("delete rs={}",test);
			}   
				if(name!=null&&!name.equals("")) {
					String savename = UUID.randomUUID().toString();
					fileUpload(savename, path, newfile);
					notice.setUploadPath(path);
					notice.setUpload(savename);
					log.debug("파일 수정={}",savename);
				} else{
					notice.setUpload(null);
					notice.setUploadPath(null);
				}
				
			
		}
		log.debug("upload-edit={}",notice.getUpload());
		notice.setHead(head);
		notice.setTitle(title);
		notice.setContent(content);
		
		noticeDao.noticeEdit(notice);
	}
	@Override
	public void fileUpload(String savename,String uploadPath,MultipartFile upload) throws Exception {

		File dir = new File(uploadPath);
		if(!dir.exists()) dir.mkdirs();
		
		log.debug("upload={}",uploadPath);
		log.debug("path  ={}",savename);
		
		File target = new File(dir, savename);
		upload.transferTo(target);
	}
	@Override
	public boolean fileDelete(String uploadPath,String upload) {
		File dir = new File(uploadPath);
		log.debug("file exist={}",dir.exists());
		File file = new File(dir,upload);
		log.debug("file exist={}",file.exists());
		log.debug("delete path={}",uploadPath+"\\"+upload);
		return file.exists()?(file.delete()):false;
	}
}
