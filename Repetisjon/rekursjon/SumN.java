class Summer{
    int n;
    Summer(int n){
        this.n = n;
    }
    int finnRekursivt(){
       return finn(n);
    }
    int finn(int n){
        if(n == 0){
            return 0;
        }
        return n + finn(n-1);
    }
}