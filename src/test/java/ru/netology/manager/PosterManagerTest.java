package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
  private final PosterItem item1 = new PosterItem(1, 1, "first", "horror", true);
  private final PosterItem item2 = new PosterItem(2, 2, "second", "horror", true);
  private final PosterItem item3 = new PosterItem(3, 3, "third", "comedy", false);
  private final PosterItem item4 = new PosterItem(4, 4, "first", "western", true);
  private final PosterItem item5 = new PosterItem(5, 5, "second", "horror", true);
  private final PosterItem item6 = new PosterItem(6, 6, "third", "comedy", true);
  private final PosterItem item7 = new PosterItem(7, 7, "first", "comedy", false);
  private final PosterItem item8 = new PosterItem(8, 8, "second", "horror", true);
  private final PosterItem item9 = new PosterItem(9, 9, "third", "western", true);
  private final PosterItem item10 = new PosterItem(10, 10, "first", "comedy", true);
  private final PosterItem item11 = new PosterItem(11, 11, "second", "comedy", true);
  private final PosterItem item12 = new PosterItem(12, 12, "third", "horror", true);

  @Test
  public void shouldReturn10Items() {
    PosterManager manager = new PosterManager();
    manager.add(item1);
    manager.add(item2);
    manager.add(item3);
    manager.add(item4);
    manager.add(item5);
    manager.add(item6);
    manager.add(item7);
    manager.add(item8);
    manager.add(item9);
    manager.add(item10);
    manager.add(item11);
    manager.add(item12);

    PosterItem[] actual = manager.getFirst();
    PosterItem[] expected = new PosterItem[]{item12, item11, item10, item9, item8, item7, item6, item5, item4, item3};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldReturnLessThan10Items() {
    PosterManager manager = new PosterManager();
    manager.add(item1);
    manager.add(item2);
    manager.add(item3);
    manager.add(item4);
    manager.add(item5);
    manager.add(item6);
    manager.add(item7);
    manager.add(item8);

    PosterItem[] actual = manager.getFirst();
    PosterItem[] expected = new PosterItem[]{item8, item7, item6, item5, item4, item3, item2, item1};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldReturn3Items() {
    PosterManager manager = new PosterManager(3);
    manager.add(item1);
    manager.add(item2);
    manager.add(item3);
    manager.add(item4);
    manager.add(item5);

    PosterItem[] actual = manager.getFirst();
    PosterItem[] expected = new PosterItem[]{item5, item4, item3};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldReturnLessThan3Items() {
    PosterManager manager = new PosterManager(3);
    manager.add(item1);
    manager.add(item2);

    PosterItem[] actual = manager.getFirst();
    PosterItem[] expected = new PosterItem[]{item2, item1};

    assertArrayEquals(expected, actual);
  }
}