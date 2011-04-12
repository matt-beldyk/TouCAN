class InterestPoint < ActiveRecord::Base
 belongs_to :layer

 validates_presence_of :words
 validates_presence_of :picture
 validates_numericality_of :lat
 validates_numericality_of :lon
end
