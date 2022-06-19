class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       List<List<String>> res = new ArrayList<>();
        
        Arrays.sort(products);
        
        for(int i=0; i<searchWord.length(); i++){
            
            int k=0;
            
            String sub = searchWord.substring(0,i+1);
            
            List<String> temp = new ArrayList<>();
            
            for(String prod : products){
                
                if(k==3) break;
                
                if(prod.startsWith(sub)){
                    temp.add(prod);
                    k++;
                }
            }
            
            res.add(temp);
            
        }
        
        return res;
    }
}