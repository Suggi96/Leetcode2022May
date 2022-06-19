class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        //<ProductWord, Sorted ID>
        TreeMap<String, Integer> map = new TreeMap<>();
        int i = 0;
        for(String product: products) {
            map.put(product, i++);
        }
        
        //ceiling(x) is >=x  lower bound
        //floor(x) is <=x  upperbound
        List<String> productList = Arrays.asList(products);
        String key = "";
        for(char c: searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key); // lowerbound ie find first word matching key
            String floor = map.floorKey(key + "{");
            
            if(ceiling==null || floor==null) break; //word itself not found
            
            
            int start = map.get(ceiling);
            int end = Math.min(map.get(ceiling) + 3, map.get(floor) + 1);
            List<String> temp = productList.subList(start, end);
            ans.add(temp);
        }
        while(ans.size() < searchWord.length())
            ans.add(new ArrayList<>());
        
        return ans;
    }
}