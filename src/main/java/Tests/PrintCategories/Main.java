package Tests.PrintCategories;

// Please complete the following exercise using Java Programming Language.
// Your solution should compile and execute successfully.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static class Category {
        // Define the following fields with getters and setters:
        //    id: a unique numeric identifier of the category
        //    parentId: id of the parent category or null if it doesn't have the parent
        //    name: a string representation of category name

        private Long id;
        private Long parentId;
        private String name;

        public Category(Long id, Long parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getParentId() {
            return parentId;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", parentId=" + parentId +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void printCat(Long parentId, String path, Map<Long, List<Category>> map) {
        List<Category> categories = map.get(parentId);
        if(categories == null) return;

        AtomicReference<String> localPath = new AtomicReference<>(path);
        categories.forEach(cat -> {
            String connector = "";
            if(cat.getParentId() == null) localPath.set("\n");
            else connector = " > ";
            final String currentPath = localPath.get() + connector + cat.getName();
            System.out.print(currentPath);
            printCat(cat.getId(), currentPath, map);
        });
    }

    public static void printPath(List<Category> categories) {
        // Input is an _unordered_ collection of categories, where "id", "parentId", and "name" are pre-populated.
        // Implement this method to print the full path for each category in the collection.
        //
        // For example, if category A is parent of category B and category B is parent of category C, then
        //      the path for category A is "A"
        //      the path for category B is "A > B"
        //      the path for category C is "A > B > C"
        //  where "A" is the name of category A
        //        "B" is the name of category B
        //        "C" is the name of category C
        //
        // Note: Number of categories in a specific path can be greater than 3 as provided in this example.
        //       Your solution should work with any number of parents (e.g. A > B > C > D > ... > X)

        Map<Long, List<Category>> map = new TreeMap<>();

        categories.forEach(cat -> {
            Long parentId = cat.getParentId();
            if(parentId == null) parentId = 0L;
            List<Category> value = map.get(parentId);
            if(value == null) {
                List<Category> list = new ArrayList<>();
                list.add(cat);
                map.put(parentId,list);
            } else {
                value.add(cat);
            }
        });

        map.forEach((k, v) -> {
            System.out.println(k + " -> " + Arrays.toString(v.toArray()));
        });

        printCat(0L, "", map);
    }

    public static void main(String... args) {
        // Define a collection of Category instances
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(30L, 10L, "Cat_30L"));
        categories.add(new Category(5L, 4L, "Cat_5L"));
        categories.add(new Category(3L, 2L, "Cat_3L"));
        categories.add(new Category(1L, null, "Cat_1L"));
        categories.add(new Category(10L, null, "Cat_10L"));
        categories.add(new Category(2L, 1L, "Cat_2L"));
        categories.add(new Category(4L, 3L, "Cat_4L"));
        categories.add(new Category(20L, 1L, "Cat_20L"));

        categories.forEach(System.out::println);
        System.out.println();

        // Invoke "printPath" method above to print the path for all the categories in the collection
        printPath(categories);
    }
}