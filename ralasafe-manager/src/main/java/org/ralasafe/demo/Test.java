package org.ralasafe.demo;

import org.ralasafe.Ralasafe;
import org.ralasafe.entitle.Decision;
import org.ralasafe.user.User;
import org.ralasafe.util.Startup;

import java.util.HashMap;
import java.util.Map;

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

        /*Role role = (Role)Factory.getRoleManager( "ralasafe" ).getRole("好汉");
        System.out.println(role);*/

        Map<String, String> context = new HashMap<>();
        context.put("marketplace", "amazon");
        Decision decision = Ralasafe.permit(PrivConstant.AMAZON_MARKET, user, null, context);
        System.out.println(decision);

        /*QueryResult  result = Ralasafe.query(Privilege.QUERY_COMPANY, user, new HashMap());
        System.out.println(result.getData());*/
    }

}
