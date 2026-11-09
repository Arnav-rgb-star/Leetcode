class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] free = new int[k];
        int[] cnt = new int[k];
        int max = 0;
        
        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<int []> busy = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        for(int i=0;i<k;i++) available.add(i);
        for(int i=0;i<arrival.length;i++){

            while(!busy.isEmpty() && busy.peek()[0]<=arrival[i]){
                int[] finished = busy.poll();
                available.add(finished[1]);
            }

            if(available.isEmpty()) continue;

            Integer server = available.ceiling(i%k);

            if(server == null) server = available.first();
            available.remove(server);

            busy.offer(new int[]{arrival[i]+load[i],server});

            cnt[server]++;
            max = Math.max(max,cnt[server]);
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<k;i++){

            if(cnt[i] == max){
                result.add(i);
            }
        }

        return result;
    }
}