#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    int q, cmd, a, b;
    char ch_a, ch_b;

    cin >> s >> q;

    for(int i=0; i<q; i++){
        cin >> cmd;

        if(cmd == 1){
            cin >> a >> b;
            char tmp = s[a-1];
            s[a-1] = s[b-1];
            s[b-1] = tmp;
        }else{
            cin >> ch_a >> ch_b;
            for(int i=0; i<s.length(); i++){
                if(s[i] == ch_a) s[i] = ch_b;
            }
        }
        cout << s << endl;
    }

    return 0;
}