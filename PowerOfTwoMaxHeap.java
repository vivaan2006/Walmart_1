public class PowerOfTwoMaxHeap {
    /**
     * creating the variables and an array of values
     */
    private int x;
    private int numSize;
    private int[] values;

    public static void main(String[] args) {

    }

    /**
     * creating a constructor and passing an int x variable
     * @param x
     */
        public PowerOfTwoMaxHeap(int x){
            this.values = new int[1];
            this.x = x;
            this.numSize = 0;
        }

    /**
     * create the insert value method which changes the arrays size
     * @param value
     */
    public void MyValues (int value){
            if (numSize == values.length) {

                newChange();
            }
            values[numSize] = value;
/**
 * compares the new elements to its parents.
 */
            int i = numSize;
            while (i > 0 && values[i] > values[(i - 1) / (int) Math.pow(2,x)]) {
                int number = values[i];
/**
 * create the calculation operations.
 */
                values[i] = values[(i - 1) / (int) Math.pow(2, x)];
                values[(i - 1) / (int) Math.pow(2, x)] = number;
                i = (i - 1) / (int) Math.pow(2, x);
            }
            numSize++;
        }

    /**
     * Make the popmax method that returns an integer
     * @return
     */
        public int valuesMaximum () {
            int maximum = values[0];
            /**
             * replacing the values
             */
            values[0] = values[numSize - 1];
/**
 * decrementing the size
 */
            numSize--;

            int i2 = 0;

            while (i2 < numSize) {

                int maxChildIndex = i2;

                for (int i = 1; i <= (int) Math.pow(2, x); i++) {

                    int childIndex = (int) Math.pow(2, x) * i2 + i;

                    if (childIndex < numSize && values[childIndex] > values[maxChildIndex]) {

                        maxChildIndex = childIndex;
                    }

                }
/**
 *
 */
            if (values[i2] < values[maxChildIndex]) {

                    int temp = values[i2];

                    values[i2] = values[maxChildIndex];

                    values[maxChildIndex] = temp;

                     i2 = maxChildIndex;

                }
            else {
                    continue;
                }
            }
            return maximum;
        }
    /**
     * method that resizes the array finally
     */
    private void newChange () {

            int[] freshValues = new int[values.length * 2];

            for (int i = 0; i < values.length; i++) {

                freshValues[i] = values[i];
            }
            values = freshValues;
        }

    }
