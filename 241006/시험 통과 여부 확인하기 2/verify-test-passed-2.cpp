#include <iostream>
using namespace std;

int main() {
    int n;
    int num;
    int cnt = 0;

    cin >> n;

    for(int i=0; i<n; i++){
        int sum = 0;
        for(int j=0; j<4; j++){
            cin >> num;
            sum += num;
        }

        if(sum >= 240){
            cout << "pass\n";
            cnt++;
        }else{
            cout << "fail\n";
        }
    }

    cout << cnt;

    return 0;
}