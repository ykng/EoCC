package test;

import java.util.ArrayList;
import java.util.List;

public class TestSrc1 {
        enum TYPE {AAA, BBB, CCC};

        public static void main(String[] args) {
                List<String> list = new ArrayList<String>();
                list.add("Foo");
                list.add("Bar");
                list.add("Baz");

                for (String str : list) {
                        System.out.println(str + " ");
                }

                for (TYPE type : TYPE.values()) {
                        System.out.println(type.name() + " ");
                }
        }
}