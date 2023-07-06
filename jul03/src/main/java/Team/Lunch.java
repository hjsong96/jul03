package Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lunch {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println("1.한식  2.탕.찌개  3.중식  4.일식  5.해장  6.간편식  7.기타  8.양식 중 하나를 선택해주세요.");
      String input = sc.next();

      String[] arraykor = { "불고기", "오징어 두루치기", "닭볶음", "쌈밥", "비빔밥", "생선구이", "낙지볶음", "게장", "떡갈비" };
      String[] arraytang = { "김치찌개", "순두부찌개", "된장찌개", "부대찌개", "동태찌개", "청국장", "갈비탕", "추어탕", "삼계탕" };
      String[] arraychina = { "짜장면", "짬뽕", "볶음밥", "탕수육", "마파두부", "양장피", "깐풍기", "유린기", "고추잡채" };
      String[] arrayyang = { "토마토 스파게티", "봉골레", "크림 파스타", "피자", "함박 스테이크", "리조또", "스테이크", "햄버거", "포케" };
      String[] arrayhae = { "복엇국", "콩나물국밥", "순대국", "뼈해장국", "우거지국", "선지해장국", "올갱이국", "매운라면", "물냉면" };
      String[] arrayjapan = { "초밥", "라멘", "낫또", "오니기리", "덮밥", "우동", "야키니쿠", "메밀소바", "돈카츠" };
      String[] arraymeal = { "도시락", "샌드위치", "토스트", "샐러드", "김밥", "떡볶이", "핫도그", "밥버거", "시리얼" };
      String[] arrayoth = { "쌀국수", "팟타이", "카페", "찜닭", "수제비", "칼국수", "아구찜", "닭갈비", "월남쌈" };

      List<String> hansik = new ArrayList<>(Arrays.asList(arraykor));
      List<String> tang = new ArrayList<>(Arrays.asList(arraytang));
      List<String> jungsik = new ArrayList<>(Arrays.asList(arraychina));
      List<String> yangsik = new ArrayList<>(Arrays.asList(arrayyang));
      List<String> haejang = new ArrayList<>(Arrays.asList(arrayhae));
      List<String> ilsik = new ArrayList<>(Arrays.asList(arrayjapan));
      List<String> mealkit = new ArrayList<>(Arrays.asList(arraymeal));
      List<String> other = new ArrayList<>(Arrays.asList(arrayoth));

      Collections.shuffle(hansik);
      Collections.shuffle(tang);
      Collections.shuffle(jungsik);
      Collections.shuffle(yangsik);
      Collections.shuffle(haejang);
      Collections.shuffle(ilsik);
      Collections.shuffle(mealkit);
      Collections.shuffle(other);

      int i = (int) Math.random() * 9;

      if (input.equals("1") || input.equals("한식")) {
         System.out.println(hansik.get(i));
      } else if (input.equals("2") || input.equals("탕") || input.equals("찌개") || input.equals("탕.찌개")) {
         System.out.println(tang.get(i));
      } else if (input.equals("3") || input.equals("중식")) {
         System.out.println(jungsik.get(i));
      } else if (input.equals("4") || input.equals("일식")) {
         System.out.println(ilsik.get(i));
      } else if (input.equals("5") || input.equals("해장")) {
         System.out.println(haejang.get(i));
      } else if (input.equals("6") || input.equals("간편식")) {
         System.out.println(mealkit.get(i));
      } else if (input.equals("7") || input.equals("기타")) {
         System.out.println(other.get(i));
      } else {
         System.out.println(yangsik.get(i));
      }
      sc.close();

   }
}