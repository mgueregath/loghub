/*
 * Tasty.
 */
package io.codeffeine.brugge.domain.pagination;

import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class Page {

    private List<?> elements;
    private int currentPage;
    private long maxPage;
    private long numberOfElements;

    public Page() {
    }

    public Page(List<?> elements, int currentPage, long maxPage, long numberOfElements) {
        this.elements = elements;
        this.currentPage = currentPage;
        this.maxPage = maxPage;
        this.numberOfElements = numberOfElements;
    }

    /**
     * @return the elements
     */
    public List<?> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(List<?> elements) {
        this.elements = elements;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the maxPage
     */
    public long getMaxPage() {
        return maxPage;
    }

    /**
     * @param maxPage the maxPage to set
     */
    public void setMaxPage(long maxPage) {
        this.maxPage = maxPage;
    }

    /**
     * @return the numberOfElements
     */
    public long getNumberOfElements() {
        return numberOfElements;
    }

    /**
     * @param numberOfElements the numberOfElements to set
     */
    public void setNumberOfElements(long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
}
