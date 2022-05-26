package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WriteFileServices<T> {

    public static <T> void save(List<T> l, String file, Class<T> clazz, boolean append) {
        try {
            new File(file).createNewFile();
        } catch (Exception e) {
            System.out.println("Error at creating the file " + file);
        }

        try (FileWriter f = new FileWriter(file, append)) {

            var memberFields = clazz.getDeclaredFields();

            List<String> memberNames = new ArrayList<>();

            for (var field : memberFields) {
                memberNames.add(field.toString().replaceAll(".*\\.", ""));
            }

            if (!append) {
                for (int j = 0; j < memberNames.size(); j++) {
                    f.write(memberNames.get(j));
                    if (j + 1 != memberNames.size()) {
                        f.write(", ");
                    }
                }
                f.write('\n');
            }

            for (var i : l) {
                for (int j = 0; j < memberNames.size(); j++) {
                    Field fld = null;
                    Class cls = i.getClass();

                    try {
                        fld = cls.getDeclaredField(memberNames.get(j));
                    } catch (Exception e) {
                    }

                    if (fld == null) {
                        fld = cls.getSuperclass().getDeclaredField(memberNames.get(j));
                    }

                    fld.setAccessible(true);
                    f.write(fld.get(i).toString());

                    if (j + 1 != memberNames.size()) {
                        f.write(", ");
                    }

                }
                f.write('\n');
            }


        } catch (IOException e) {
            System.out.println("Error at opening file " + file);
        } catch (Exception e) {
            System.out.println("Error at writing in the file " + file);
        }

    }
}
