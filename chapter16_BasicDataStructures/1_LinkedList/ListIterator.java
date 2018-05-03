public interface ListIterator
{
  Object next();
  boolean hasNext();
  Object remove();
  void add(Object element);
  void set(Object element);
}
