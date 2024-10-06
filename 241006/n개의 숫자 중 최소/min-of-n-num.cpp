#include <iostream>
#include <climits>
using namespace std;

int main() {
    int N, num;
    int min = INT_MAX, cnt = 0;

    cin >> N;

    for(int i=0; i<N; i++){
        cin >> num;
        if(num < min){
            min = num;
            cnt = 1;
        }else if(num == min) cnt++;
    }

    cout << min << ' ' << cnt;

    return 0;
}