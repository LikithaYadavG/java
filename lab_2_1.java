public class lab_2_1 {
        public static void main(String[] args) {
            StringBuffer stringBuffer = new StringBuffer("Hello");

            stringBuffer.append(" World");
            System.out.println("After append(): " + stringBuffer);

            stringBuffer.insert(6, " Java");
            System.out.println("After insert(): " + stringBuffer);
 
            stringBuffer.replace(6, 11, " Universe");
            System.out.println("After replace(): " + stringBuffer);

            stringBuffer.delete(6, 15);
            System.out.println("After delete(): " + stringBuffer);

            char charAtIndex = stringBuffer.charAt(2);
            System.out.println("charAt(2): " + charAtIndex);

            stringBuffer.setCharAt(2, 'X');
            System.out.println("After setCharAt(): " + stringBuffer);

            int length = stringBuffer.length();
            System.out.println("Length: " + length);

            int capacity = stringBuffer.capacity();
            System.out.println("Capacity: " + capacity);

            stringBuffer.ensureCapacity(20);
            System.out.println("After ensureCapacity(): " + stringBuffer);

            String str = stringBuffer.toString();
            System.out.println("toString(): " + str);

            String substringFromIndex = stringBuffer.substring(2);
            System.out.println("substring(2): " + substringFromIndex);

            String substringRange = stringBuffer.substring(2, 6);
            System.out.println("substring(2, 6): " + substringRange);
        }
    }
    
