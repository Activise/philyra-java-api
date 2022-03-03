package eu.activise.philyra.paging;

import java.util.List;

public interface PagedList<T> {
  
  public PagedList<T> getPage(int page, int count);

  public PagedList<T> getPage(int page);

  public PagedList<T> nextPage();

  public PagedList<T> previousPage();

  public void setCountPerPage(int countPerPage);
  
  public int getCountPerPage();

  public int getCurrentPage();

  public long count();

  public int pageCount();

  public List<? extends T> asJavaList();
  
}
