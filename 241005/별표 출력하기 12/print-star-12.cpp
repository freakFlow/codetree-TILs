#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(j % 2 == 0){
                cout << (i > 0 ? ' ' : '*');
            }else{
                cout << (i > j ? ' ' : '*');
            }
            cout << ' ';
        }
        cout << endl;
    }

    return 0;
}