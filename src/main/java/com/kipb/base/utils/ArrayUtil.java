package com.kipb.base.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ObjectUtils;

public class ArrayUtil 
{
	@FunctionalInterface
	public interface  ArrayProcessor<T>
	{
		void process(List<T> list);
	}
	

	public static <T> Predicate<T> distinctByKey( Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new HashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
    /**
     * list를 size수로 분할 하여 반환하는 함수
     * 
     * @param <T>
     * @param list
     * @param size
     * @return
     */
    public static <T> Collection<List<T>> partitionBasedOnSize(List<T> list, int size) {
        final AtomicInteger counter = new AtomicInteger(0);
        return list.stream()
                    .collect(Collectors.groupingBy(s -> counter.getAndIncrement() / size))
                    .values();
    }
    
    /**
     * list를 size로 분할해 ArrayProcessor 실행
     * 
     * @param <T>
     * @param list
     * @param size
     * @param processor
     * @return
     */
    public static <T> boolean partitionBasedOnSize(List<T> list, int size, ArrayProcessor processor)
	{
		if(ObjectUtils.isEmpty(list))
		{
			return true;
		}
		
		if(size < 1)
		{
			size = 100;
		}
		
		Collection<List<T>> listCollection = ArrayUtil.partitionBasedOnSize(list, size);
		for(List<T> listPartition : listCollection)
		{
			processor.process(listPartition);
		}
		
		return true;
	}

	/**
	 * 두개 리스트 merge한 리스트 반환
	 *
	 * @param list1
	 * @param list2
	 * @return
	 * @param <T>
	 */
	public static <T> List<T> merge(List<T> list1, List<T> list2)
	{
		List<T> result = new ArrayList<>();

		if(ObjectUtils.isNotEmpty(list1))
		{
			result = list1;
		}

		if(ObjectUtils.isNotEmpty(list2))
		{
			result.addAll(list2);
		}

		return result;
	}

	/**
	 * formList를 toList에 머지.
	 *
	 * @param toList
	 * @param formList
	 * @param <T>
	 */
	public static <T> void mergeAddAll(List<T> toList, List<T> formList)
	{
		if(toList == null || ObjectUtils.isEmpty(formList))
		{
			return;
		}

		toList.addAll(formList);
	}
}
