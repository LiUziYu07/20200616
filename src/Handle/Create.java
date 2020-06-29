package Handle;

import Community.Discussion;
import Utils.DiscussionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到微信小程序的请求");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("这里是创建响应");
        req.setCharacterEncoding("utf-8");

        String type = req.getParameter("type");
        if(type.equals("CreateDis")){
            String discussion_name = req.getParameter("title");
            String discussion_description = req.getParameter("description");
            Discussion discussion = new Discussion();
            DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();

            List<Discussion> discussionList = discussionDao.selectAll();

            discussion.setDiscussion_id(discussionList.size()+1);
            discussion.setAdminId(1);
            discussion.setDiscussion_title_img_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");
            discussion.setDiscussion_name(discussion_name);
            discussion.setDescription(discussion_description);

            discussionDao.insert(discussion);
        }
    }
}