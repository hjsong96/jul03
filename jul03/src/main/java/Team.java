
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
   public static void main(String[] args) {
      String[] team = { "구관모", "기상민", "김민성", "김수진", "김요한", "박지윤", "배기주", "송다원", "송재윤", "송화진", "안희진", "유영조", "유종휘",
            "이대원", "이상화", "이승현", "이지선", "정대규", "정준식", "최범식", "최지은", "표해현", "차승리", "황선우", "박채아" };

      List<String> project = new ArrayList<String>();
      for (int i = 0; i < team.length; i++) {
         project.add(team[i]);
      }

      Collections.shuffle(project);

      System.out.println("┌───────┬────────────────────────────────────┐");
      System.out.println("│ 팀 명 │\t\t팀원\t\t     │");
      System.out.println("├───────┼────────────────────────────────────┤");
      
      int index = 0;
      for (int i = 0; i < 5; i++) {
         System.out.printf("│  %d조\t│ ", i + 1);
         for (int j = i * 5; j < (i + 1) * 5; j++) {
            System.out.printf("%s ",project.get(index));
            index++;
         }
         System.out.println("│");
      }
      System.out.println("└───────┴────────────────────────────────────┘");

   }
}