#include <iostream>
using namespace std;

int main() {
    int n;
    int cnt = 3;

    cin >> n;
    int num;
    for(int i=1; i<=n; i++){
        cin >> num;
        if(num == 2){
            cnt--;
            if(cnt == 0){
                cout << i;
                break;
            }
        }
    }

    return 0;
}