class Solution {

    class CustomObj {
        int value;
        int idx;
        int freq;

        CustomObj(int value, int idx, int freq) {
            this.value = value;
            this.idx = idx;
            this.freq = freq;
        }
    }

    class FreqComparator implements Comparator<CustomObj> {

        @Override
        public int compare(CustomObj o1, CustomObj o2) {
            if (o1.freq != o2.freq) {
                return o1.freq - o2.freq;
            }
            if (o1.value != o2.value) {
                return o2.value - o1.value;
            }
            return o1.idx - o2.idx;
        }
    }

    public int[] frequencySort(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        CustomObj[] customObjArr = new CustomObj[n];
        for (Integer i : arr) {
            if (freqMap.containsKey(i)) {
                int val = freqMap.get(i);
                freqMap.put(i, ++val);
            } else {
                freqMap.put(i, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            customObjArr[i] = new CustomObj(arr[i], i, freqMap.containsKey(arr[i]) ? freqMap.get(arr[i]) : 0);
        }
        Arrays.sort(customObjArr, new FreqComparator());
        for (int i = 0; i < n; i++) {
            arr[i] = customObjArr[i].value;
        }
        return arr;
    }
}
