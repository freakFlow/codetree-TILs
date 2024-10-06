#include <iostream>
using namespace std;

int main() {
    int arrA[100], arrB[100];
    int n1, n2;
    bool isYes = false;

    cin >> n1 >> n2;

    for(int i=0; i<n1; i++){
        cin >> arrA[i];
    }
    for(int i=0; i<n2; i++){
        cin >> arrB[i];
    }

    for(int diff=0; diff<=n1-n2; diff++){
        bool check = true;
        for(int i=0; i<n2; i++){
            if(arrA[i+diff] != arrB[i]){
                check = false;
                break;
            }
        }

        if(check){
            isYes = true;
            break;
        }
    }

    cout << (isYes ? "Yes" : "No");

    return 0;
}