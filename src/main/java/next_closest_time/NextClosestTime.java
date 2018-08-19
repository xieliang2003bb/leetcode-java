package next_closest_time;

/**
 * Created by lxie on 8/18/18.
 */
public class NextClosestTime {

    public String nextClosestTime(String time) {
        StringBuilder res = new StringBuilder("0000");
        int[] v = {600, 60, 10, 1};
        int found = time.indexOf(":");
        int cur = Integer.parseInt(time.substring(0, found)) * 60 +
                Integer.parseInt(time.substring(found + 1));
        for (int i = 1, d = 0; i <= 1440; ++i) {
            int next = (cur + i) % 1440;
            for (d = 0; d < 4; ++d) {
                res.setCharAt(d, (char) ('0' + next / v[d]));
                next %= v[d];
                if (time.indexOf(res.charAt(d)) < 0) break;
            }
            if (d >= 4) break;
        }
        return res.substring(0, 2) + ":" + res.substring(2);
    }

    public static void main(String[] args) {
        NextClosestTime n = new NextClosestTime();
        System.out.println(n.nextClosestTime("23:59"));

    }


}
