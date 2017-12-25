package controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.apply.AcceptApplyController;
import controller.apply.CancelApplyController;
import controller.apply.ViewFarmApplyController;
import controller.apply.ViewMachineApplyController;
import controller.community.DeletePostController;
import controller.community.ListPostController;
import controller.community.UpdatePostController;
import controller.community.ViewPostController;
import controller.community.WriteCommentController;
import controller.community.WritePostController;
import controller.farm.ApplyFarmController;
import controller.farm.ListFarmController;
import controller.farm.RegistFarmController;
import controller.farm.ViewFarmController;
import controller.machine.RegistMachineController;
import controller.machine.ApplyMachineController;
import controller.machine.ListMachineController;
import controller.machine.ViewMachineController;
import controller.user.DeleteUserController;
import controller.user.ListUserController;
import controller.user.LoginController;
import controller.user.LogoutController;
import controller.user.RegisterUserController;
import controller.user.UpdateUserController;
import controller.user.UpdateUserFormController;
import controller.user.ViewUserController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/login/success", new ForwardController("/member/index2.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/login/form", new ForwardController("/member/loginForm.jsp"));
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/register", new RegisterUserController()); 
        mappings.put("/user/register/form", new ForwardController("/member/registerForm.jsp"));
        mappings.put("/user/logout", new LogoutController());
        
        mappings.put("/user/view", new ViewUserController());
        mappings.put("/user/update", new UpdateUserController()); 
        mappings.put("/user/update/form", new UpdateUserFormController()); 
        mappings.put("/user/delete", new DeleteUserController()); 
        
        //Farm
        mappings.put("/farm/register", new RegistFarmController());
        //mappings.put("/farm/regist/form", new ForwardController("/farm/registerForm.jsp"));
        mappings.put("/farm/list", new ListFarmController());
        mappings.put("/farm/detail", new ViewFarmController());
        mappings.put("/farm/apply", new ApplyFarmController());
        
        //Machine
        mappings.put("/machine/register", new RegistMachineController());
        //mappings.put("/farm/regist/form", new ForwardController("/rental/registerForm.jsp"));
        mappings.put("/machine/list", new ListMachineController());
        mappings.put("/machine/detail", new ViewMachineController());
        mappings.put("/machine/apply", new ApplyMachineController());
        
        //Community
        mappings.put("/community/list", new ListPostController());
        mappings.put("/community/detail", new ViewPostController());
        mappings.put("/community/write", new WritePostController());
        mappings.put("/community/update", new UpdatePostController());
        mappings.put("/community/delete", new DeletePostController());
        mappings.put("/community/comment", new WriteCommentController());
        
        mappings.put("/apply/farmList", new ViewFarmApplyController());
        mappings.put("/apply/farmOk", new AcceptApplyController());
        mappings.put("/apply/farmCancel", new CancelApplyController());
        
        mappings.put("/apply/machineList", new ViewMachineApplyController());
        mappings.put("/apply/machineOk", new AcceptApplyController());
        mappings.put("/apply/machineCancel", new CancelApplyController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {   
       
        return mappings.get(uri);
    }
}
