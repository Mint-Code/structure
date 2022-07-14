package structure;

public class StructureArray<E> {
    
    private Object[] elementList = new Object[0];

    public StructureArray() {
        super();
    }

    public Object[] toArray() {
        return elementList;
    }

    public String toString() {
        String string = "[";
        for(Object element : elementList) {
            string += element.toString();
            string += ", ";
        }
        string = string.substring(0, string.length() - 2);
        string += "]";
        return string;
    }

    public int getLength() {
        return elementList.length;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        try {
            return (E) (elementList[index]);
        } catch(Exception err) {
            return null;
        }
    }

    public <T extends E> void add(T element) {
        Object[] elementList = new Object[this.elementList.length + 1];
        for(int i = 0; i < this.elementList.length; i++) {
            elementList[i] = this.elementList[i];
        }
        elementList[elementList.length - 1] = element;
        this.elementList = elementList;
    }

    public <T extends E> void remove() {
        remove(elementList.length - 1);
    }

    public <T extends E> void remove(int index) {
        Object[] elementList = new Object[this.elementList.length - 1];
        int newIndex = 0;
        for(int i = 0; i < this.elementList.length; i++) {
            if(i != index) {
                elementList[newIndex] = this.elementList[i];
                newIndex += 1;
            }
        }
        this.elementList = elementList;
    }
}
