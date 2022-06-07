class Solution {
    
    List<String> result = new ArrayList<>();
    char[][] b;
    Node root = new Node();
    public List<String> findWords(char[][] board, String[] words) {
        b=board;
        for(String word : words)
            addWord(word);
        boolean[][] visited = new boolean[b.length][b[0].length];
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b[0].length; j++){
                if(root.containsKey(b[i][j]))
                    dfs(i, j, root,  visited );
            }
        }
        return result;
    }
    
    public void dfs (int i, int j, Node node, boolean[][] visited){
        if(i<0 || i>= b.length || j<0 || j>=b[0].length || visited[i][j] || !node.containsKey(b[i][j]))
            return;
        visited[i][j] = true;
        Node next = node.get(b[i][j]);
        if(next.word != null){
            result.add(next.word);
            next.word = null;
        }
        dfs(i+1, j, next,  visited );
        dfs(i, j+1, next,  visited );
        dfs(i-1, j, next,  visited );
        dfs(i, j-1, next,  visited );
        
        visited[i][j] = false;
    }
    
    
    public void addWord(String word){
        Node node = root;
        for(char c : word.toCharArray()){
            node.putIfAbsent(c, new Node());
            node = node.get(c);
        }
        node.word=word;
    }
        
}

public class Node extends HashMap<Character, Node>{
    String word;
}