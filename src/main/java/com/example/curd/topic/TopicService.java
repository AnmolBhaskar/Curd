package com.example.curd.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	final static List<Topic> topic;
	static {
			topic = new ArrayList<>(Arrays.asList(new Topic("PH", "1", "Physics"), new Topic("MT", "2", "Maths")));
	}
	private List<Topic> topics;
	
	@Autowired 
	TopicRepository repository;
	
	public List<Topic> getTopics() {
		System.out.println("At get topics");
		topics = new ArrayList<>();
		if(repository.findAll() != null) {
			repository.findAll().forEach(TopicService.topic::add);
		}
		return topics;
	}

	public Topic getTopic(String id) {

	return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();

	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void deleteTopic(String topicId) {
		topics.remove(getTopic(topicId));
		
	}

	public void updateTopic(Topic topic) {
		Topic dbObj = getTopic(topic.getId());
		
		dbObj.setDescription(topic.getDescription());
		dbObj.setId(topic.getId());
		dbObj.setName(topic.getName());
	}
}