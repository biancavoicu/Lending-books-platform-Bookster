package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReadFileServices<T> {

    public static <T> List<T> load(String file, Class<T> clazz) {

        try (BufferedReader fileBuffer = new BufferedReader(new FileReader(file))) {

            List result = new ArrayList<T>();

            String row;
            List<String> memberNames = new ArrayList<String>();

            {
                row = fileBuffer.readLine();

                if (row == null) {
                    return result;
                }
                String[] data = row.split(",");

                for (String d : data) {
                    memberNames.add(d.trim());
                }
            }

            while ((row = fileBuffer.readLine()) != null) {
                String[] data = row.split(",");
                var inst = clazz.getConstructor().newInstance();

                for (int i = 0; i < memberNames.size(); i++) {
                    Class cls = inst.getClass();
                    Field fld = null;

                    try {
                        fld = cls.getDeclaredField(memberNames.get(i));
                    } catch (Exception e) {
                    }

                    if (fld == null) {
                        fld = cls.getSuperclass().getDeclaredField(memberNames.get(i));
                    }

                    fld.setAccessible(true);

                    if (fld.getType() == String.class) {
                        fld.set(inst, data[i]);
                    } else if (fld.getType() == int.class) {
                        fld.set(inst, Integer.parseInt(data[i]));
                    } else if (fld.getType() == float.class) {
                        fld.set(inst, Float.parseFloat(data[i]));
                    }

                }

                result.add(inst);

            }

            return result;
        } catch (IOException e) {
            System.out.println("Error at opening file " + file);
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Other error");
            return new ArrayList<>();
        }
    }
}
