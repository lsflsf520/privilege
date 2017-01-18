package org.ralasafe.demo;

import org.ralasafe.Factory;
import org.ralasafe.privilege.Role;
import org.ralasafe.user.User;
import org.ralasafe.util.Startup;

/**
 * Created by neko on 2017/1/11.
 */
public class Test {

    public static void main(String[] args){
        User user = new User();
        user.setId(4);

        String datasourceDir = "/Users/neko/workspace/oceanwing/ralasafe_colddew/ralasafe-manager/src/main/webapp/WEB-INF/ralasafe/";
        String repoDir = "/Users/neko/workspace/oceanwing/ralasafe_colddew/ralasafe-manager/src/main/webapp/xml";
        Startup.startup(datasourceDir, repoDir);
        /*boolean result = Ralasafe.hasPrivilege(PrivConstant.RET_MONEY, user);

        System.out.println(result);*/

        Role role = (Role)Factory.getRoleManager( "ralasafe" ).getRole("好汉");
        System.out.println(role);
    }

}
