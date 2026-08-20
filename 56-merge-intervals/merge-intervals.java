class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1])));

        
        int l = intervals[0][0];
        int r = intervals[0][1];
        int n = intervals.length;
        int k=1;
        for(int i=1;i<n;i++){
            int start= intervals[i][0];
            int end= intervals[i][1];

            if(start <= r){
                ans.get(k-1).set(0, Math.min(l, start));
                ans.get(k-1).set(1, Math.max(r, end));

                l = Math.min(l,start);
                r = Math.max(r,end);
            }else{
                ans.add(new ArrayList<>());
                ans.get(k).add(start);
                ans.get(k).add(end);

                l=start;
                r=end;
                ++k;
            }
        }        
        int [][]m = new int[ans.size()][2];

        for(int i=0;i<ans.size();i++){
            m[i][0] =  ans.get(i).get(0);
            m[i][1] = ans.get(i).get(1);
        }
        return m;
    }
}