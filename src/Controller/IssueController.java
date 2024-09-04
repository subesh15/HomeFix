package Controller;

import java.util.ArrayList;

import Model.IssueDAO;
import Resources.IssueDTO;
import Util.Cookie;

public class IssueController {
    public static ArrayList<IssueDTO> viewissue() throws Exception{
        IssueDAO view=IssueDAO.getInstanceIssueDAO();
        return view.viewissue();
    }

    public static ArrayList<IssueDTO> viewstatus() throws Exception{
        IssueDAO view=IssueDAO.getInstanceIssueDAO();
        ArrayList<IssueDTO> arr=view.viewstatus(Cookie.getUser().getUser_id());
        return arr;
    }

    public static ArrayList<IssueDTO> viewbooktech() throws Exception{
        IssueDAO view=IssueDAO.getInstanceIssueDAO();
        ArrayList<IssueDTO> arr=view.viewbooktech(Cookie.getUser().getUser_id());
        return arr;
    }

    public static void updateStatus(int id,int uid) throws Exception{
        IssueDAO issueModal=IssueDAO.getInstanceIssueDAO();
        if(!issueModal.updateStatus(id,uid))
            throw new Exception("Enter valid user_id u already booked");

    }
    
}
