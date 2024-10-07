#include <iostream>
using namespace std;

int main() {
    int N;
    int arr[1001];

    cin >> N;

    for(int i=1; i<=N; i++){
        cin >> arr[i];
    }

    while(N > 0){
        int max = 0, maxIdx;
        for(int i=N; i>0; i--){
            if(arr[i] >= max){
                max = arr[i];
                maxIdx = i;
            }
        }

        cout << maxIdx << ' ';
        N = maxIdx - 1;
    }

    return 0;
}