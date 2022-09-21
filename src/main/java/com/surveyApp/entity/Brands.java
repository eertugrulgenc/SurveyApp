package com.surveyApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brands")
public class Brands {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int submitId;
	
	@Column(name="topic_Id")
	private int topicId;
	
	@Column(name="topic")
	private String topic;
	
	@Column(name="score")
	private int score;
	
	@Column(name="feed_Back")
	private String feedBack;
	
	
	public Brands() {
		
	}

	public Brands(int topicId, String topic, int score, String feedBack) {
		this.topicId = topicId;
		this.topic = topic;
		this.score = score;
		this.feedBack = feedBack;
	}

	public int getSubmitId() {
		return submitId;
	}

	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	@Override
	public String toString() {
		return "Brands [submitId=" + submitId + ", topicId=" + topicId + ", topic=" + topic + ", score=" + score
				+ ", feedBack=" + feedBack + "]";
	}
	
	
}
