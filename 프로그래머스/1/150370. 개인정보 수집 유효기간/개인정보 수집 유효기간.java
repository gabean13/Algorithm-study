import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Privacy[] privacyList = new Privacy[privacies.length];
        StringTokenizer st = new StringTokenizer(today, ".");
        
        //today 입력
        Date todayDate = new Date(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        //terms 입력
        Map<String, Integer> termMap = new HashMap<>();
        for(String input : terms) {
            st = new StringTokenizer(input);
            termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        //privacy 입력
        int size = 0;
        for(int i = 0; i < privacies.length; i++) {
            String input = privacies[i];
            st = new StringTokenizer(input);
            String date = st.nextToken();
            String termType = st.nextToken();
            st = new StringTokenizer(date, ".");
            Date startDate = new Date(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            privacyList[i] = new Privacy(i+1, termType, startDate);
            privacyList[i].setEndDate(termMap.get(termType));
            if(privacyList[i].setIsExpired(todayDate)) {
                size++;
            }
        }
        
        int[] answer = new int[size];
        int idx = 0;
        for(Privacy privacy : privacyList) {
            if(privacy.isExpired) {
                answer[idx++] = privacy.id;
            }
        }
        
        return answer;
    }
    
    //번호, 약관 종류, 개인정보 수집 일자, 개인정보 만료 일자, 개인정보 만료 여부
    static class Privacy {
        int id;
        String termType;
        Date startDate;
        Date endDate;
        boolean isExpired;
        
        public Privacy (int id, String termType, Date startDate) {
            this.id = id;
            this.termType = termType;
            this.startDate = startDate;
        }
        
        public void setEndDate(int termLength) {
            Date endDate = new Date(startDate.year, startDate.month ,startDate.day);
            endDate.month += termLength;
            while(endDate.month > 12) {
                endDate.year++;
                endDate.month -= 12;
            }
            
            this.endDate = endDate;
        }
        
        public boolean setIsExpired(Date today) {
            //2022.05.19 / 2019.01.01
            //2022.05.19 / 2022.04.12
            //2022.05.19 / 2022.05.18 
            if(today.year > endDate.year) {
                isExpired = true;
                return isExpired;
            } else if(today.year < endDate.year) {
                isExpired = false;
                return isExpired;
            }
            
            if(today.month > endDate.month) {
                isExpired = true;
                return isExpired;
            } else if(today.month < endDate.month) {
                isExpired = false;
                return isExpired;
            }
            
            if(today.day >= endDate.day) {
                isExpired = true;
                return isExpired;
            } 
            isExpired = false;
            return isExpired;
        }
    }
    
    static class Date {
        int year;
        int month;
        int day;
        
        public Date (int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
}