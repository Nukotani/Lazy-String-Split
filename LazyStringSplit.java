import java.util.Iterator;
import java.util.NoSuchElementException;
//TODO: GENERICS! 
public class LazyStringSplit implements Iterator<String> {
  private String document;
  private char delimiter;
  private int currentIndex;

  public LazyStringSplit(String document, char delimiter) {
    this.document = document;
    this.delimiter = delimiter;
    this.currentIndex = 0;
  }

  @Override
  public boolean hasNext() {
    return currentIndex < document.length();
  }

  @Override
  public String next() {
    if(!hasNext()) {
      throw new NoSuchElementException(); }

    StringBuffer buffer = new StringBuffer();
    int i = currentIndex;
    char c;

    while(((c = document.charAt(i)) != delimiter) && i < document.length()) {
      buffer.append(c);
      i++;
    }
    i++;
    currentIndex = i;

    return new String(buffer);
  } 
}
