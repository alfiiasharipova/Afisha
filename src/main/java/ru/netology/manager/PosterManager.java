package ru.netology.manager;

import ru.netology.domain.PosterItem;


public class PosterManager {
  private final int arrayLenght;
  private PosterItem[] items = new PosterItem[0];

  public PosterManager() {
    this.arrayLenght = 10;
  }
  public PosterManager(int arrayLenght) {
    this.arrayLenght = arrayLenght;
  }


  public void add(PosterItem item) {
    // создаём новый массив размером на единицу больше
    int length = items.length + 1;
    PosterItem[] tmp = new PosterItem[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    // кладём последним наш элемент
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public PosterItem[] getFirst() {
    int lenght = Math.min(items.length, arrayLenght);
    PosterItem[] result = new PosterItem[lenght];
      // перебираем массив в прямом порядке
      // но кладём в результаты в обратном
    for (int i = 0; i < lenght; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }
}
