#include <iostream>
using namespace std;

int main() {
    int N;
    int count[1001] = {};
    int max = -1;

    cin >> N;

    for(int i=0; i<N; i++){
        int num;
        cin >> num;
        count[num]++;
    }

    for(int i=1000; i>0; i--){
        if(count[i] == 1){
            max = i;
            break;
        }
    }

    cout << max;

    return 0;
}