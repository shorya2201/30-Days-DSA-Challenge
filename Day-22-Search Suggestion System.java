class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> retList = new ArrayList<List<String>>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> listString = new ArrayList<String>();
            for (int j = 0; j < products.length; j++) {
                if (listString.size() < 3 && i < products[j].length()
                        && (products[j].substring(0, i + 1).equals(searchWord.substring(0, i + 1)))) {
                    listString.add(products[j]);
                }
            }
            
                retList.add(listString);
            
        }
        return retList;
    }
}
