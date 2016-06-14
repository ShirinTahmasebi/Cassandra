package ir.ac.sbu.redisproject.util;

public class Tag {

    /*
     user model fields
     */
    final public static String USER = "user";
    final public static String USER_ID = "userId";
    final public static String USER_NAME = "userName";
    final public static String USER_PASSWORD = "password";
    final public static String REDIS_USER_KEY = "users";

    /*
     item model fields
     */
    final public static String ITEM = "item";
    final public static String ITEM_ID = "itemId";
    final public static String ITEM_NAME = "itemName";
    final public static String REDIS_ITEM_KEY = "items";


    /*
     project model fields
     */
    final public static String PROJECT = "project";
    final public static String PROJECT_NAME = "projectName";
    final public static String PROJECT_BUDGET = "budget";
    final public static String PROJECT_DEADLINE = "deadline";
    final public static String PROJECT_DESCRIPTION = "description";
    final public static String PROJECT_NEEDED_SKILLS = "neededSkills";
    final public static String PROJECT_ID = "projectId";

    /*
     requested project model fields
     */
    final public static String REQUESTED_PROJECTS = "RequestedProjects";
    final public static String REQUESTED_PROJECTS_PRICE = "price";
    final public static String REQUESTED_PROJECTS_DEADLINE = "deadline";
    final public static String REQUESTED_PROJECTS_DESCRIPTION = "description";

    /*
     resume model fields
     */
    final public static String RESUME = "resume";
    final public static String RESUME_ID = "resumeId";
    final public static String RESUME_DESCRIPTION = "resumeDescription";

    /*
     resumeItem model fields
     */
    final public static String RESUME_ITEM = "resumeItem";
    final public static String RESUME_ITEM_ID = "itemId";
    final public static String RESUME_ITEM_NAME = "itemName";
    final public static String RESUME_ITEM_LEVEL = "itemLevel";
    final public static String RESUME_ITEM_DESCIRPTION = "itemDescription";

    /*
     Page names strings
     */
    final public static String LOGIN_PAGE = "login.jsp";
    final public static String REGISTER_PAGE = "register.jsp";
    final public static String FIRST_PAGE = "first_page.jsp";
    final public static String CREATE_NEW_PROJECT_PAGE = "creat_new_project.jsp";
    final public static String PROJECT_DETAILS_PAGE = "project_details.jsp";
    final public static String ADD_RESUME_ITEM_PAGE = "add_resume_item.jsp";
    final public static String USER_EDITABLE_PROFILE_PAGE = "user_profile_editable.jsp";
    final public static String CREATE_RECOMMENDATION_PAGE = "recommendation.jsp";
    final public static String EDIT_PROFILE_PAGE = "edit_profile.jsp";
    final public static String CREATE_NEW_ITEM_PAGE = "create_new_item.jsp";

    final public static String PERSISTANCE_UNIT_NAME = "UserService";

    /*
     Redis basic configuration data
     */
    public static final String REDIS_HOST = "localhost";
    public static final Integer REDIS_PORT = 6379;

}
