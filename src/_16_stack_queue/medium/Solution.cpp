class Solution {
public:
    string recurse(string &s, int &index)
    {
        string ret;
        while(index<s.length() && s[index]!=']')
        {
            if(!isdigit(s[index]))
                ret+=s[index++];
            else
            {
                int k=0;
                while(index<s.length()&&isdigit(s[index]))
                    k = k*10 + s[index++]-'0';
                index++; //because digit always accompanied by '['
                string dec = recurse(s, index);
                index++; //and accompanied by a closing ']' too
                while(k-- > 0)
                    ret+=dec;
            }
        }
        return ret;
    }
    string decodeString(string s) {
        int index = 0;
        return recurse(s, index);

    }
};