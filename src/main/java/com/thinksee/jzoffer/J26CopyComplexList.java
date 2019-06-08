package com.thinksee.jzoffer;

/**
 * 实现函数ComplexListNode* Clone(ComplexListNode* pHead),
 * 复制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针
 * 指向下一个结点外，还有一个m_pSibling指向链表中的任意结点或NULL。
 */
public class J26CopyComplexList {
    class ComplexListNode{
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }
}
