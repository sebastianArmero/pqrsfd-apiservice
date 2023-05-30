package com.smartcampus.repositories;

import java.util.List;

public interface IEntityRepository<E, I> {


	public void create(E r);

	public void update(I id, E r);

	public void deleteWithUpdate(I id);
	
	public void delete(I id);

	public List<E> showAll();

	public E showById(I id);
	
}
