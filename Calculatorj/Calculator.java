class Calculator{
    float answer;

    void solve(String expression){
        int o = 0, n = 0;
        char[] operations = new char[10];
        float[] numbers = new float[25];
        for (int i = 0; i < expression.length(); i++){
            String ch = String.valueOf(expression.charAt(i));
            if ("%*+-/^".contains(ch)){
                operations[o] = expression.charAt(i);
                o++;
            } else if ("0123456789".contains(ch)){
                int j = 0;
                String num = "";
                for (j = 0;(i+j) < expression.length(); j++){
                    if ("0123456789".contains(String.valueOf(expression.charAt(i+j)))){
                        num+=String.valueOf(expression.charAt(i+j));
                    } else {
                        break;
                    }
                }
                numbers[n] = Float.parseFloat(num);
                n++;
                i+=j-1;
            }
        }
        calculate(numbers, operations);
    }

    void calculate(float[] numbers, char[] operations){
        for (int i = 0; i < operations.length; i++){
            int opM = max(operations);
            if ("^/".contains(String.valueOf(operations[opM]))){
                char op = operations[opM];
                if (op == '/'){
                    numbers[opM] = numbers[opM]/numbers[opM+1];
                } else {
                    numbers[opM] = power(numbers[opM],(int) numbers[opM+1]);
                }
                operations = remove(operations, opM);
                numbers = remove(numbers, opM+1);
            } else if ("-+".contains(String.valueOf(operations[opM]))){
                int opm = min(operations);
                if ("%*".contains(String.valueOf(operations[opm]))){
                    char op = operations[opm];
                    if (op == '*'){
                        numbers[opm] = numbers[opm]*numbers[opm+1];
                    } else {
                        numbers[opm] = numbers[opm]%numbers[opm+1];
                    }
                    operations = remove(operations, opm);
                    numbers = remove(numbers, opm+1);
                } else {
                    char op = operations[opM];
                    if (op == '+'){
                        numbers[opM] = numbers[opM]+numbers[opM+1];
                    } else {
                        numbers[opM] = numbers[opM]-numbers[opM+1];
                    }
                    operations = remove(operations, opM);
                    numbers = remove(numbers, opM+1);
                }
            } else if ("*%".contains(String.valueOf(operations[opM]))){
                char op = operations[opM];
                if (op == '*'){
                    numbers[opM] = numbers[opM] * numbers[opM+1];
                } else {
                    numbers[opM] = numbers[opM] % numbers[opM+1];
                }
                operations = remove(operations, opM);
                numbers = remove(numbers, opM+1);
            }
        }
        answer = numbers[0];
    }

    float power(float a,int b){
        if (b==0){
            return 1;
        }
        return a*power(a,b-1);
    }

    int max(char[] list){
        char m = list[0];
        int index = 0;
        for (int i = 1;i < list.length; i++){
            if (m < list[i]){
                m = list[i];
                index = i;
            }
        }
        return index;
    }

    int min(char[] list){
        char m = list[0];
        int index = 0;
        for (int i = 0; i < list.length; i++){
            if (m > list[i] && list[i]!=0){
                m = list[i];
                index = i;
            }
        }
        return index;
    }

    float[] remove(float[] list, int index){
        float[] rlist = new float[list.length];
        int j = 0;
        for (int i = 0; i < list.length; i++){
            if (index != i){
                rlist[j] = list[i];
                j++;
            }
        }
        return rlist;
    }

    char[] remove(char[] list, int index){
        char[] rlist = new char[list.length];
        int j = 0;
        for (int i = 0; i < list.length; i++){
            if (index != i){
                rlist[j] = list[i];
                j++;
            }
        }
        return rlist;
    }
}