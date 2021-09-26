package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q253_Meeting_Rooms_II {
    private int answer;
    private List<Meeting> sortedMeeting;
    private List<Meeting> progressMeetings;

    class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public int minMeetingRooms(int[][] intervals) {
        setup(intervals);
        getAnswer();
        return answer;
    }


    private void setup(int[][] intervals) {
        answer = 0;
        List<Meeting> inputs = new ArrayList<>();
        for (int[] interval: intervals) {
            inputs.add(new Meeting(interval[0], interval[1]));
        }
        sortedMeeting = inputs.stream().sorted((m1, m2) -> {
            if (m1.start - m2.start > 0) return 1;
            else if (m1.start - m2.start < 0) return -1;
            else return m1.end - m2.end;
        }).collect(Collectors.toList());
        progressMeetings = new ArrayList<>();
    }


    private void getAnswer() {
        int time = 0;
        while( !sortedMeeting.isEmpty() ) {
            terminateMeeting(time);
            if (sortedMeeting.get(0).start == time) {
                progressMeetings.add(sortedMeeting.remove(0));
                answer = answer < progressMeetings.size() ? progressMeetings.size() : answer;

                if ( !sortedMeeting.isEmpty() && sortedMeeting.get(0).start == time) {
                    continue;
                } else {
                    time++;
                }
            } else {
                time++;
            }
        }
    }


    private void terminateMeeting(int time) {
        for (int idx = 0; idx < progressMeetings.size(); ) {
            if (progressMeetings.get(idx).end == time) {
                progressMeetings.remove(idx);
            } else {
                idx++;
            }
        }
    }
}
