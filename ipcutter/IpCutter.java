package ipcutter;

import java.util.StringTokenizer;

public class IpCutter {

    public static boolean validate(String ip) {
        String pattern = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";

        return ip.matches(pattern);
    }

    /**
     * first method to cut ip address
     * 
     * @param ip
     */
    public static void cutterMeth1(String ip) {
        System.out.println("***** Cutter method one Split ******");
        for (String chunck : ip.split("\\.")) {
            System.out.println(chunck);
        }
    }

    /**
     * second method to cut ip address
     * 
     * @param ip
     */
    public static void cutterMethod2(String ip) {
        StringTokenizer st = new StringTokenizer(ip, "\\.");

        System.out.println("***** Cutter Method two StringTokenizer ***** ");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    /**
     * third method to cut ip address
     * 
     * @param ip
     */
    public static void cutterMethod3(String ip) {
        String part = ip.substring(0, ip.indexOf("."));
        System.out.println("*** Cutter method three indexOf and substring ***");

        while (!part.isEmpty()) {
            System.out.println(part);
            ip = ip.substring(ip.indexOf(".") + 1) + ".";
            part = ip.substring(0, ip.indexOf("."));
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String ip = args[0];

            if (validate(ip)) {

                cutterMeth1(ip);

                cutterMethod2(ip);

                cutterMethod3(ip);

            } else {
                System.out.println("Not valid ip address");
            }
        } else {
            System.out.println("No ip address inserted");
        }

    }
}
