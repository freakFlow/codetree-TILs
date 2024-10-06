#include <iostream>
using namespace std;

int main() {
    int n, q;
    int arr[101];
    int oper, a, b;

    cin >> n >> q;
    for(int i=1; i<=n; i++){
        cin >> arr[i];
    }

    for(int i=0; i<q; i++){
        cin >> oper >> a;
        if(oper == 1){
            cout << arr[a] << endl;
        }else if(oper == 2){
            int idx = 0;
            for(int j=1; j<=n; j++){
                if(arr[j] == a){
                    idx = j;
                    break;
                }
            }
            cout << idx << endl;
        }else if(oper == 3){
            cin >> b;
            for(int j=a; j<=b; j++){
                cout << arr[j] << ' ';
            }
            cout << endl;
        }
    }

    return 0;
}