package naver.finantial.p2.java;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String s, String[] times) {
        final String[] date = s.split(":");
        final LocalDateTime dateTime = LocalDateTime.of(
                Integer.parseInt(date[0]),
                Integer.parseInt(date[1]),
                Integer.parseInt(date[2]),
                Integer.parseInt(date[3]),
                Integer.parseInt(date[4]),
                Integer.parseInt(date[5])
        );

        final List<LocalDateTime> dateTimes = new ArrayList<>();
        dateTimes.add(dateTime);

        for (String time : times) {
            final String[] split = time.split(":");
            LocalDateTime last = dateTimes.get(dateTimes.size() - 1);
            last = last.plusSeconds(Integer.parseInt(split[3]));
            last = last.plusMinutes(Integer.parseInt(split[2]));
            last = last.plusHours(Integer.parseInt(split[1]));
            last = last.plusDays(Integer.parseInt(split[0]));
            dateTimes.add(last);
        }

        final int period = dateTimes.get(dateTimes.size() - 1).getDayOfMonth() - dateTimes.get(0).getDayOfMonth() + 1;
        int[] answer = {1, period};
        for (int i = 1; i < dateTimes.size(); i++) {
            if (dateTimes.get(i).getDayOfMonth() - dateTimes.get(i - 1).getDayOfMonth() > 1) {
                answer[0] = 0;
                break;
            }
        }

        return answer;
    }
}
